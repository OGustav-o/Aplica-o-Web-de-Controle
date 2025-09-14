import React from 'react'
import { Item } from '../types'


export default function ItemCard({ item }: { item: Item }) {
    return (
        <div className="bg-white p-4 rounded shadow-sm">
            <h3 className="font-semibold">{item.name}</h3>
            <p className="text-sm text-gray-600">{item.description}</p>
            <div className="text-xs text-gray-500 mt-2">Qty: {item.quantity ?? 0}</div>
        </div>
    )
}