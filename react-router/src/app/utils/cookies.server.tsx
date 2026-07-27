import { createCookie } from "react-router";

export const jwtCookie = createCookie("jwt", {
    httpOnly: true,
    secure: process.env.NODE_ENV === "production", // skip this
    sameSite: "lax",
    path: "/",
});