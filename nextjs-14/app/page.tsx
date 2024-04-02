'use client'

import { useState } from "react"
import axios from 'axios';
import Link from "next/link";
import './globals.css'
import { Button, Input } from "@mui/material";
import { NextPage } from "next";
import { PG } from "@/redux/common/enums/PG";

const SERVER = 'http://localhost:8080'
const HomePage:NextPage=()=> {
  const [name, setName] = useState('')
  const handleChange = (e:any)=> {
    setName(e.target.value)
  }
 
  const handleClick = ()=> {
    alert('리퀘스트가 가져가는 이름 : '+name)
    const url = `${SERVER}/name`
    const data = {'name': name}
    const config = {
      headers:{
        "Cache-Control": "no-cache",
        "Content-Type": "application/json",
         Authorization: `Bearer blah ~` ,
        "Access-Control-Allow-Origin": "*",
    }}
    axios.post(url,data,config)
    .then(res=>{
      alert('alert : '+JSON.stringify(res.data))
      console.log('console : '+JSON.stringify(res.data))
    }
      )
  
  }

  return (<div className='text-center'>
  <div>welcom to react world !</div><br />
  <h3 className='text-red-500'>이름 입력</h3><br />
  <h3>사이트</h3>
    <Link href={PG.USER} >user</Link><br/>
    <Link href={"/store"} >store</Link><br/>
    <Link href={PG.BOARD+"/articles"} >articles</Link><br/>
    <Link href={PG.BOARD} >board</Link><br/>
    <Link href={PG.DEMO+"/companys"} >companys</Link><br/>
    <Link href={PG.DEMO+"/mui-demo"} >mui-demo</Link><br/>
    <Link href={PG.DEMO+"/counter"} >demo</Link><br/>
    <Link href={PG.DEMO+"/redux-counter"} >redux-counter</Link>
  </div>)


}
export default HomePage