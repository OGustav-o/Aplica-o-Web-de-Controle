const TOKEN_KEY = 'access_token'


export function saveToken(token: string) {
    localStorage.setItem(TOKEN_KEY, token)
    setAuthToken(token)
}


export function getToken(): string | null {
    return localStorage.getItem(TOKEN_KEY)
}


export function clearToken() {
    localStorage.removeItem(TOKEN_KEY)
    setAuthToken(null)
}


export async function login(username: string, password: string) {
    const res = await api.post('/auth/login', { username, password })
    return res.data // { accessToken, tokenType, expiresIn }
}