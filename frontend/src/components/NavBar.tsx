import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { clearToken } from '../services/auth'


export default function NavBar() {
    const navigate = useNavigate()
    function logout() {
        clearToken()
        navigate('/login')
    }
    return (
        <nav className="bg-white shadow p-4 flex justify-between">
            <div className="flex items-center gap-4">
                <Link to="/" className="font-bold">Access Items</Link>
                <Link to="/items" className="text-sm text-gray-600">Items</Link>
            </div>
            <div>
                <button onClick={logout} className="text-sm text-red-600">Logout</button>
            </div>
        </nav>
    )
}