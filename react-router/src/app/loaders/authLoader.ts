import {jwtCookie} from "../utils/cookies.server";

export type AuthLoaderData = {
    user: { token: string } | null;
};

export async function tokenLoader({ request }: { request: Request }) {
    const cookieHeader = request.headers.get("Cookie");
    const token = await jwtCookie.parse(cookieHeader);

    return {
        user: token ? { token } : null,
    } satisfies AuthLoaderData;
}