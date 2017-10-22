import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { ItemService, Item } from '../entities';

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

    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private itemService: ItemService
        ) {
    }

    ngOnInit() {
        this.principal.identity().then((account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
        this.eventManager.subscribe('unMessage', (message) => {
            this.setValeur(message.content);
        });
        this.itemService.getAllItems().subscribe((data) => {
            for (const item of data){
                console.log('item.imageUrl : ' + JSON.stringify(item.imageUrl));
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

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    getItemsByType(typeName: string) {
        console.log('le nom du type cliqué est ' + typeName);

        this.itemService.getItemsByTypeName(typeName).subscribe((data) => {
            for (const item of data){
                if (item.imageUrl === null) {
                    item.imageUrl = require('../../content/images/not-found.png');
                } else {
                    item.imageUrl = require('../../content/images/' + item.imageUrl);
                }
            }
            /*console.log('good ' + JSON.stringify(data));*/
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
