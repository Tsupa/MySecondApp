import { Routes } from '@angular/router';

import { itemRoute } from './item/item.route';

const ENTITY_ROUTES = [ itemRoute ];

export const entityState: Routes = [{
    path: '',
    children: ENTITY_ROUTES
}];
