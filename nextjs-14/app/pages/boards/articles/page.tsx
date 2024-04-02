'use client'
import axios from "axios"
import { useEffect, useState } from "react"
import { DataGrid } from '@mui/x-data-grid';
import Box from '@mui/material/Box';
import Link from "next/link";
import ArticleColumns from "@/app/component/columns/article-columns";
import ArticleRows from "@/app/component/rows/article-rows";
import { NextPage } from "next";
import MuiDemoRows from "@/app/component/rows/mui-demo-rows";
import Columns from "@/app/component/articles/columns";


const MArticlePage:NextPage=({data}:any)=> {
  
  // const handleSubmit(()=>{
  //   axios.post()
  //   .then
  // })

  return (<>
    <h2>게시글 목록</h2>
  <Box sx={{ height: 400, width: '100%' }}>
  <DataGrid
    rows={data}
    columns={Columns()}
    initialState={{
      pagination: {
        paginationModel: {
          pageSize: 5,
        },
      },
    }}
    pageSizeOptions={[5]}
    checkboxSelection
    disableRowSelectionOnClick
  />
</Box>
{/* <button><Link href={handleSubmit} >글쓰기</Link></button> */}
</>
  )
}
export default MArticlePage