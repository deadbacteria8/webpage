import { createBrowserRouter } from "react-router";
import { Layout } from "./components/Layout";
import { Feed } from "./pages/Feed";
import { Profile } from "./pages/Profile";
import Login, { action as loginAction } from "./pages/Login";
import {tokenLoader} from "./loaders/authLoader";


export const router = createBrowserRouter([
  {
    path: "/",
    Component: Layout,
    loader: tokenLoader,
    children: [
      { index: true, Component: Feed },
      { path: "profile/:id", Component: Profile },
    ],
  },
  {
    path: "login",
    Component: Login,
    action: loginAction,
  },
]);