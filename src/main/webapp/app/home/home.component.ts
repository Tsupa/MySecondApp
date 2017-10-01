import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Home } from './home.service';

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

    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private homeService: Home
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
        this.homeService.getAllItems().subscribe((data) => {
            console.log('good ' + JSON.stringify(data.json()));
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

    login() {
        this.modalRef = this.loginModalService.open();
    }

    setValeur(valeur) {
        this.uneValeur = valeur;
    }
}
