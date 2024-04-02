//이거는 수업을 위한 테스트 페이지입니다.(나머지를 다 아토믹패턴을 적용해 버려서..)
'use client'

import axios from "axios"
import { useRouter } from "next/navigation"
import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import {Box, Button, Input, Link} from '@mui/material';
import { API } from "@/redux/common/enums/API";
import AxiosConfig from "@/redux/common/configs/axios-config";
import { useSelector, useDispatch } from 'react-redux'
import { NextPage } from "next";
import { fetchAllArticles } from "@/redux/features/articles/article.service";
import { getAllArticles } from "@/redux/features/articles/article.slice";
// import { IArticle } from "@/redux/features/articles/article.model";
// import React from "react";


interface IArticle {
    id: number,
    title: string,
    content: string,
    writer: string,
    registerDate: string
}

const ArtilcesPage: NextPage = () => {
    const dispatch = useDispatch()
   const allArticles: [] = useSelector(getAllArticles)

    if(allArticles !== undefined){
        console.log('allArticles is not undefined')
        
        console.log('length is '+ allArticles.length)
        for(let i=0; i< allArticles.length; i++){
            console.log(JSON.stringify(allArticles[i]))
        }
    }else{
        console.log('allArticles is undefined')
    }
    

    useEffect(() => {
        dispatch(fetchAllArticles(1))
    }, [])
    
    return (<>
        <h2>개인페이지 Article</h2>
        <table border={1}>
            <thead>
                <tr>
                    <th>title</th>
                    <th>content</th>
                    <th>writer</th>
                    <th>registerDate</th>
                </tr>
            </thead>
            <tbody>
                {allArticles?.map((props: IArticle) => (
                    <tr key={props.id}>
                        <td>{props.title}</td>
                        <td>{props.content}</td>
                        <td>{props.writer}</td>
                        <td>{props.registerDate}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </>)
}

export default ArtilcesPage