import { createAsyncThunk } from "@reduxjs/toolkit";
import { fetchAllUsersAPI } from "./user.api";

export const fetchAllUsers: any = createAsyncThunk(
    'users/fetchAllUsers',
    async (page: number)=>{
        console.log('page : '+ page)
        const data:any = await fetchAllUsersAPI(1);
        return data
    }
)