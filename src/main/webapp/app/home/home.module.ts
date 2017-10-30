import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MySecondAppSharedModule } from '../shared';

import { HOME_ROUTES, HomeComponent } from './';

import { MomentModule } from 'angular2-moment';

@NgModule({
    imports: [
        MySecondAppSharedModule,
        RouterModule.forRoot(HOME_ROUTES, { useHash: true }),
        MomentModule
    ],
    declarations: [
        HomeComponent,
    ],
    entryComponents: [
    ],
    providers: [
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MySecondAppHomeModule {}
