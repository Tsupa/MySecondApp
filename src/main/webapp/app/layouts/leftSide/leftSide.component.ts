import { Component, OnInit, OnDestroy, HostListener, ElementRef } from '@angular/core';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    selector: 'jhi-leftside',
    templateUrl: './leftSide.component.html'
})
export class LeftSideComponent implements OnInit, OnDestroy {

    lists: any[];
    selectedItem: any;

    constructor(private eventManager: JhiEventManager, private _eref: ElementRef) {
        this.lists = ['Alpha', 'Beta', 'Gamma', 'Delta', 'Epsilon'];
    }

    @HostListener('document:click') onClick($event) {
        if (!this._eref.nativeElement.contains(event.target)) {
            this.selectedItem = '';
            this.eventManager.broadcast({ name: 'unMessage',
                content: ''});
        }
    }

    ngOnInit() {
        console.log('im here');
    }

    ngOnDestroy() {
    }

    listClick(event, newValue) {
        this.selectedItem = newValue;
        this.eventManager.broadcast({ name: 'unMessage',
                content: newValue});
    }
}
