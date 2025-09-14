import React, { useEffect, useState } from 'react'
import api from '../services/api'
import NavBar from '../components/NavBar'
import ItemCard from '../components/ItemCard'
import { Item } from '../types'
import { Link } from 'react-router-dom'


export default function ItemsList() {
    const [items, setItems] = useState<Item[]>([])
    const [loading, setLoading] = useState(true)


useEffect(() => {
    (async () => {
    try {
        const res = await api.get('/items')
        // backend returns Page, so use content or map accordingly
        const data = res.data
        // if backend returns Page: data.content
        setItems(Array.isArray(data) ? data : (data.content ?? data))
        } finally {
        setLoading(false)
    }
    })()
}, [])


    return (
        <div className="min-h-screen">
            <NavBar />
            <div className="max-w-4xl mx-auto p-6">
                <div className="flex justify-between items-center mb-4">
                    <h1 className="text-xl font-bold">Items</h1>
                    <Link to="/items/new" className="bg-green-600 text-white px-3 py-1 rounded">Novo item</Link>
                </div>
                {loading ? <div>Carregando...</div> : (
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                        {items.map((it: Item) => <ItemCard key={it.id} item={it} />)}
                    </div>
                )}
            </div>
        </div>
    )
}