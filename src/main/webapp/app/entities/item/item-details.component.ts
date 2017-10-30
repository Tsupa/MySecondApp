import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';

import { Item } from './item.model';
import { ItemService } from './item.service';

@Component({
    selector: 'jhi-item-detail',
    templateUrl: './item-details.component.html'
})
export class ItemDetailComponent implements OnInit, OnDestroy {

    item: Item;
    private subscription: Subscription;

    constructor(
        private itemService: ItemService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {

        this.subscription = this.route.params.subscribe((params) => {
            console.log('ItemDetailComponent : ngOnInit')
            this.load(params['idItem']);
        });
    }

    load(idItem) {
        this.itemService.find(idItem).subscribe((item) => {
            this.item = item;
            if (item.imageUrl === null) {
                item.imageUrl = require('../../../content/images/not-found.png');
            } else {
                item.imageUrl = require('../../../content/images/' + item.imageUrl);
            }
        });
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

}
