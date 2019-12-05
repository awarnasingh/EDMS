export interface IConfigure {
    id?: number,
    name?: string
}

export class Configure  implements IConfigure {
    constructor(
        public id?: number,
        public name?: string
    ) {
    }


}
