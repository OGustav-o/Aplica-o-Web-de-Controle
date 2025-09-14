export interface Item {
    id?: number;
    name: string;
    description?: string | null;
    quantity?: number;
}


export interface User {
    id?: number;
    username: string;
    fullName?: string;
    roles?: string[];
}