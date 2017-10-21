import { Category } from './category.model';

export class Item {
    public id?: any;
    public active?: Boolean;
    public description?: string;
    public duration?: number;
    public name?: string;
    public number?: number;
    public imageUrl?: string;
    public categories?: Category[];
    public lastModifiedDate?: String;

    constructor(
        id?: any,
        active?: Boolean,
        description?: string,
        duration?: number,
        name?: string,
        number?: number,
        imageUrl?: string,
        categories?: Category[],
        lastModifiedDate?: String
        ) {
        this.id = id ? id : null;
        this.active = active ? active : null;
        this.description = description ? description : null;
        this.duration = duration ? duration : null;
        this.name = name ? name : null;
        this.number = number ? number : null;
        this.imageUrl = imageUrl ? imageUrl : null;
        this.categories = categories ? categories : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
