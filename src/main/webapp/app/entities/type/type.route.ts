import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, Route, CanActivate } from '@angular/router';

import { JhiPaginationUtil } from 'ng-jhipster';

import { TypeDetailComponent } from './type-details.component';

export const typeRoute: Route = {
        path: 'type',
        component: TypeDetailComponent,
        data: {
            pageTitle: 'items'
        }
    };
