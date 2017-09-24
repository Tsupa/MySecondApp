import { Route } from '@angular/router';

import { NavbarComponent, LeftSideComponent } from './layouts';

export const navbarRoute: Route = {
    path: '',
    component: NavbarComponent,
    outlet: 'navbar'
};

export const leftSideRoute: Route = {
    path: '',
    component: LeftSideComponent,
    outlet: 'leftSide'
};
