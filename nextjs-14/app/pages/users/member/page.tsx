'use client'

import { fetchAllUsers } from "@/redux/features/users/user.service"
import { getAllUsers } from "@/redux/features/users/user.slice"
import { NextPage } from "next"
import { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"

interface IUser{
    id: number,
    username: string,
    password: string,
    name: string,
    phone: string,
    recommender:string
}

const UsersPage: NextPage = () => {

    const dispatch = useDispatch()
    const [users, setUsers] = useState([])
    const allUsers: [] = useSelector(getAllUsers)

    if(allUsers !== undefined){
        console.log('not undefined')

        for(let i=0; i<allUsers.length; i++){
            console.log(JSON.stringify(allUsers[i]))
        }
    }else{
        console.log('undefined')
    }

    useEffect(() => {
        dispatch(fetchAllUsers(1))
    }, [])

    return (<>
<h2>개인페이지 Users</h2>
        <table border={1}>
            <thead>
                <tr>
                    <th>username</th>
                    <th>password</th>
                    <th>name</th>
                    <th>phone</th>
                    <th>recommender</th>
                </tr>
            </thead>
            <tbody>
                {allUsers?.map((props: IUser) => (
                    <tr key={props.id}>
                        <td>{props.username}</td>
                        <td>{props.password}</td>
                        <td>{props.name}</td>
                        <td>{props.phone}</td>
                        <td>{props.recommender}</td>
                    </tr>
                ))}
            </tbody>
        </table>    
        </>)
}
export default UsersPage