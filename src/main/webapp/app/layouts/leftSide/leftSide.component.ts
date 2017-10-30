import { Component, OnInit, OnDestroy, HostListener, ElementRef } from '@angular/core';
import { JhiEventManager } from 'ng-jhipster';
import { TypeService, Type } from '../../entities';

@Component({
    selector: 'jhi-leftside',
    templateUrl: './leftSide.component.html'
})
export class LeftSideComponent implements OnInit, OnDestroy {

    lists: any[];
    types: Type[];
    selectedItem: any;

    constructor(private eventManager: JhiEventManager,
    private _eref: ElementRef,
    private typeService: TypeService) {
        this.lists = ['Alpha', 'Beta', 'Gamma', 'Delta', 'Epsilon'];
    }

    @HostListener('document:click') onClick($event) {
        if (!this._eref.nativeElement.contains(event.target)) {
            this.selectedItem = '';
            this.eventManager.broadcast({ name: 'updateHomePage',
                content: ''});
        }
    }

    ngOnInit() {
        this.typeService.getActivableTypes().subscribe((data) => {
            for (const item of data){
                console.log('item.imageUrl : ' + JSON.stringify(item.imageUrl));
                if (item.imageUrl === null) {
                    item.imageUrl = require('../../../content/images/not-found.png');
                } else {
                    item.imageUrl = require('../../../content/images/' + item.imageUrl);
                }
            }
            /*console.log('good ' + JSON.stringify(data));*/
            this.types = data;
        }, (response) => console.log('error'));

    }

    ngOnDestroy() {
    }

    listClick(event, newValue) {
        this.selectedItem = newValue;
        /*this.eventManager.broadcast({ name: 'updateHomePage',
                content: newValue});*/
    }
}
