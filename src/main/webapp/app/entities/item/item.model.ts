
export class Item {
    public id?: any;
    public active?: Boolean;
    public description?: string;
    public duration?: number;
    public name?: string;
    public typeName?: string;
    public number?: number;
    public imageUrl?: string;
    public categoriesName?: string[];
    public lastModifiedDate?: String;

    constructor(
        id?: any,
        active?: Boolean,
        description?: string,
        duration?: number,
        name?: string,
        typeName?: string,
        number?: number,
        imageUrl?: string,
        categoriesName?: string[],
        lastModifiedDate?: String
        ) {
        this.id = id ? id : null;
        this.active = active ? active : null;
        this.description = description ? description : null;
        this.duration = duration ? duration : null;
        this.name = name ? name : null;
        this.typeName = typeName ? typeName : null;
        this.number = number ? number : null;
        this.imageUrl = imageUrl ? imageUrl : null;
        this.categoriesName = categoriesName ? categoriesName : null;
        this.lastModifiedDate = lastModifiedDate ? lastModifiedDate : null;
    }
}
