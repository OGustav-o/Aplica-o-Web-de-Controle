import { useState } from "react";
import { useAuth } from "../auth/AuthContext";

export default function Login() {
  const { login } = useAuth();
  const [username,setU]=useState(""); const [password,setP]=useState("");
  const [err,setErr]=useState("");

  async function submit(e){
    e.preventDefault();
    try { await login(username,password); }
    catch(e){ setErr("Credenciais inválidas"); }
  }

  return (
    <form onSubmit={submit} style={{maxWidth:360,margin:"4rem auto"}}>
      <h2>Login</h2>
      <input value={username} onChange={e=>setU(e.target.value)} placeholder="usuário" />
      <input value={password} onChange={e=>setP(e.target.value)} type="password" placeholder="senha" />
      <button type="submit">Entrar</button>
      {err && <p>{err}</p>}
    </form>
  );
}
