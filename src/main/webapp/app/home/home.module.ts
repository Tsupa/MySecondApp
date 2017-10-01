import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MySecondAppSharedModule } from '../shared';

import { HOME_ROUTE, HomeComponent, Home } from './';

@NgModule({
    imports: [
        MySecondAppSharedModule,
        RouterModule.forRoot([ HOME_ROUTE ], { useHash: true })
    ],
    declarations: [
        HomeComponent,
    ],
    entryComponents: [
    ],
    providers: [
    Home
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MySecondAppHomeModule {}
