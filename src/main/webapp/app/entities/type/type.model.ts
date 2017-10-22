
export class Type {
    public id?: any;
    public active?: Boolean;
    public description?: string;
    public duration?: number;
    public name?: string;
    public number?: number;
    public imageUrl?: string;
    public numberAssociatedItems?: number;

    constructor(
        id?: any,
        active?: Boolean,
        description?: string,
        duration?: number,
        name?: string,
        number?: number,
        imageUrl?: string,
        numberAssociatedItems?: number
        ) {
        this.id = id ? id : null;
        this.active = active ? active : null;
        this.description = description ? description : null;
        this.duration = duration ? duration : null;
        this.name = name ? name : null;
        this.number = number ? number : null;
        this.imageUrl = imageUrl ? imageUrl : null;
        this.numberAssociatedItems =  numberAssociatedItems ? numberAssociatedItems : null;
    }
}
