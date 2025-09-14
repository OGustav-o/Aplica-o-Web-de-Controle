import { useEffect, useState } from 'react'
import { getToken, saveToken, clearToken } from '../services/auth'
import api, { setAuthToken } from '../services/api'


export function useAuth() {
    const [token, setToken] = useState<string | null>(() => getToken())
    const [loading, setLoading] = useState(false)


useEffect(() => {
    setAuthToken(token)
}, [token])


async function signin(username: string, password: string) {
    setLoading(true)
    try {
        const data = await api.post('/auth/login', { username, password })
        const token = data.data.accessToken
        saveToken(token)
        setToken(token)
    return true
    } finally {
        setLoading(false)
    }
}


function signout() {
    clearToken()
    setToken(null)
}


    return { token, loading, signin, signout }
}