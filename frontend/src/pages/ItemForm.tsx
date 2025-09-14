import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import api from '../services/api'
import NavBar from '../components/NavBar'
import { Item } from '../types'


export default function ItemForm() {
    const { id } = useParams<{ id?: string }>()
    const navigate = useNavigate()
    const [item, setItem] = useS