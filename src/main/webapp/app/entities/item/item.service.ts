import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { SERVER_API_URL } from '../../app.constants';
import { Item } from './item.model';

@Injectable()
export class ItemService {

    constructor(private http: Http) {}

    getAllItems(): Observable<Item[]> {
        return this.http.get(SERVER_API_URL + 'api/items').map((res: Response) => res.json());
    }
}
