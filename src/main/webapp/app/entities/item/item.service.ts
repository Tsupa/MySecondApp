import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';
import { Item } from './item.model';

@Injectable()
export class ItemService {
    private resourceUrl = SERVER_API_URL + 'api/items';

    constructor(private http: Http) {}

    getAllItems(): Observable<Item[]> {
        return this.http.get(SERVER_API_URL + 'api/items/all').map((res: Response) => res.json());
    }

    getItemsByTypeName(typeName: string): Observable<Item[]> {
        return this.http.get(`${this.resourceUrl}/byTypeName/${typeName}`).map((res: Response) => res.json());
    }
}
