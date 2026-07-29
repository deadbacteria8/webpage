import { useLoaderData } from "react-router";
import {AuthLoaderData} from "../loaders/authLoader";


export function useAuth() {
    const data = useLoaderData() as AuthLoaderData;

    return {
        token: data.user?.token,
        isAuthenticated: !!data.user?.token,
        user: data.user,
    };
}