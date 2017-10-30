import { Route, Routes } from '@angular/router';

import { UserRouteAccessService } from '../shared';
import { HomeComponent } from './';

export const HOME_ROUTE: Route = {
    path: '',
    component: HomeComponent,
    data: {
        authorities: [], pageTitle: 'Accueil'
    }
};

export const HOME_ROUTES: Routes = [
    {
        path: '',
        component: HomeComponent,
        data: {
authorities: [],
pageTitle: 'Accueil'
        }
    },
    {
        path: 'home/:typeName',
        component: HomeComponent,
        data: {
authorities: [],
pageTitle: 'Accueil'
        }
    }
];
