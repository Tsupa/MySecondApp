import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MySecondAppSharedModule } from '../shared';

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

import { ItemService, TypeService, ItemDetailComponent, entityState } from './';

@NgModule({
    imports: [MySecondAppSharedModule,
    RouterModule.forRoot(entityState, { useHash: true })
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [ ItemDetailComponent ],
    entryComponents: [],
    providers: [ItemService, TypeService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MySecondAppEntityModule {}
