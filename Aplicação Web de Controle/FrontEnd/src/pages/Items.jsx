import { useEffect, useState } from "react";
import { api } from "../api/axios";

export default function Items(){
  const [items,setItems]=useState([]);
  const [name,setName]=useState("");
  const [description,setDescription]=useState("");

  useEffect(()=>{ api.get("/api/items").then(r=>setItems(r.data)); },[]);
  async function add(){
    const {data} = await api.post("/api/items",{name,description});
    setItems(prev=>[...prev,data]); setName(""); setDescription("");
  }

  return (
    <div style={{maxWidth:720,margin:"2rem auto"}}>
      <h2>Items</h2>
      <ul>{items.map(i=> <li key={i.id}>{i.name} — {i.description}</li>)}</ul>
      <div>
        <input value={name} onChange={e=>setName(e.target.value)} placeholder="nome" />
        <input value={description} onChange={e=>setDescription(e.target.value)} placeholder="descrição" />
        <button onClick={add}>Adicionar</button>
      </div>
    </div>
  );
}
