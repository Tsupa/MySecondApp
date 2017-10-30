import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { ItemService, Item } from '../entities';
import { Subscription } from 'rxjs/Rx';
import { ActivatedRoute } from '@angular/router';

import { Account, LoginModalService, Principal } from '../shared';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: [
    'home.css'
    ]

})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    uneValeur: string;
    items: Item[];
    private subscription: Subscription;

    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private itemService: ItemService,
        private route: ActivatedRoute
        ) {
        console.log('HomeComponent : construvtoor');
    }

    ngOnInit() {
        console.log('HomeComponent : ngOnInit');
        this.principal.identity().then((account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
        this.eventManager.subscribe('updateHomePage', (message) => {
            if (message.content === 'Nouveautés') {
                this.getAllItems();
            }
            this.setValeur(message.content);
        });
        this.subscription = this.route.params.subscribe((params) => {
            console.log('HomeComponent : subscription ' + params['typeName']);
            if (params['typeName'] === undefined) {
                this.getAllItems();
            } else {
                this.getItemsByType(params['typeName']);
            }
        });
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    getAllItems() {
        console.log('HomeComponent : getAllItems');
        this.itemService.getAllItems().subscribe((data) => {
            for (const item of data){
                // console.log('item.imageUrl : ' + JSON.stringify(item.imageUrl));
                if (item.imageUrl === null) {
                    item.imageUrl = require('../../content/images/not-found.png');
                } else {
                    item.imageUrl = require('../../content/images/' + item.imageUrl);
                }
            }
            /*console.log('good ' + JSON.stringify(data));*/
            this.items = data;
        }, (response) => console.log('error'));
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    getItemsByType(typeName: string) {
        console.log('HomeComponent : getItemsByType');
        this.itemService.getItemsByTypeName(typeName).subscribe((data) => {
            for (const item of data){
                if (item.imageUrl === null) {
                    item.imageUrl = require('../../content/images/not-found.png');
                } else {
                    item.imageUrl = require('../../content/images/' + item.imageUrl);
                }
            }
            // console.log('good ' + JSON.stringify(data));
            this.items = data;
            this.setValeur(typeName);
        }, (response) => console.log('error'));
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    setValeur(valeur) {
        this.uneValeur = valeur;
    }
}
