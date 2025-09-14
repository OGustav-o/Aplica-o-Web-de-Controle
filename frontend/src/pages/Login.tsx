import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { saveToken } from '../services/auth'
import api from '../services/api'


export default function Login() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [error, setError] = useState<string | null>(null)
    const navigate = useNavigate()


    async function submit(e: React.FormEvent) {
    e.preventDefault()
    setError(null)
    try {
        const res = await api.post('/auth/login', { username, password })
        const token = res.data.accessToken
        saveToken(token)
        navigate('/items')
        } catch (err: any) {
        setError(err?.response?.data?.error || 'Erro ao autenticar')
    }
}


return (
    <div className="min-h-screen flex items-center justify-center">
        <div className="w-full max-w-md bg-white p-8 rounded shadow">
            <h2 className="text-2xl mb-4">Login</h2>
            {error && <div className="text-red-600 mb-2">{error}</div>}
            <form onSubmit={submit} className="space-y-4">
                <div>
                    <label className="block text-sm">Usuário</label>
                    <input className="w-full border p-2 rounded" value={username} onChange={e => setUsername(e.target.value)} />
                </div>
                <div>
                    <label className="block text-sm">Senha</label>
                    <input type="password" className="w-full border p-2 rounded" value={password} onChange={e => setPassword(e.target.value)} />
                </div>
                <div>
                    <button className="w-full bg-blue-600 text-white p-2 rounded">Entrar</button>
                </div>
            </form>
        </div>
    </div>
    )
}