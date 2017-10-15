export class Category {
    public id?: any;
    public active?: Boolean;
    public description?: string;
    public name?: string;

    constructor(
        id?: any,
        active?: Boolean,
        description?: string,
        name?: string
        ) {
        this.id = id ? id : null;
        this.active = active ? active : null;
        this.description = description ? description : null;
        this.name = name ? name : null;
    }
}
