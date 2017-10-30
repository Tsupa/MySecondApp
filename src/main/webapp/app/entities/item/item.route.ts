import { Route } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ItemDetailComponent } from './item-details.component';

export const itemRoute: Route = {
    path: 'item/:idItem',
    component: ItemDetailComponent,
    data: {
        authorities: [],
        pageTitle: 'items'
    },
    canActivate: [UserRouteAccessService]
};
