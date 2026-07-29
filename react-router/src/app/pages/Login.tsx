import {redirect, Link, Form} from "react-router";
import { motion } from "motion/react";
import { jwtCookie } from "../utils/cookies.server";

export async function loader() {
}

export async function action({ request }: { request: Request }) {

    const FormData = await request.formData();

    const username = FormData.get("username");
    const password = FormData.get("password");

    let backendUrl = process.env.BACKEND_URL;

    const response = await fetch(`${backendUrl}/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
    });

    if (!response.ok) {
        return { error: "Login failed" };
    }

    const data = await response.json();

    const cookieHeader = await jwtCookie.serialize(data.jwt);

    return redirect("/", {
        headers: {
            "Set-Cookie": cookieHeader,
        },
    });
}

export default function Login({ actionData }: any) {
    return (
        <div className="min-h-screen bg-gray-50">
            <header className="fixed top-0 left-0 right-0 z-50 bg-black text-white">
                <div className="max-w-7xl mx-auto px-6">
                    <div className="flex items-center justify-between h-16">
                        <Link to="/" className="text-2xl font-bold tracking-tighter">
                            SYNC
                        </Link>
                    </div>
                </div>
            </header>

            <div className="pt-32 max-w-md mx-auto px-6">
                <motion.div
                    initial={{ opacity: 0, y: 20 }}
                    animate={{ opacity: 1, y: 0 }}
                    className="bg-white p-8"
                >
                    <h1 className="text-3xl font-bold tracking-tight mb-2">Sign in</h1>
                    <p className="text-gray-600 mb-8">Welcome back to SYNC</p>

                    <Form method="post" className="space-y-6">
                        <div>
                            <label htmlFor="username" className="block text-sm tracking-wide mb-2">
                                USERNAME
                            </label>
                            <input
                                id="username"
                                name="username"
                                type="text"
                                required
                                className="w-full border border-gray-300 px-4 py-3 focus:outline-none focus:border-black transition-colors"
                            />
                        </div>

                        <div>
                            <label htmlFor="password" className="block text-sm tracking-wide mb-2">
                                PASSWORD
                            </label>
                            <input
                                id="password"
                                name="password"
                                type="password"
                                required
                                className="w-full border border-gray-300 px-4 py-3 focus:outline-none focus:border-black transition-colors"
                            />
                        </div>

                        {actionData?.error && (
                            <p className="text-red-600 text-sm">
                                {actionData.error}
                            </p>
                        )}

                        <button
                            type="submit"
                            className="w-full bg-black text-white py-3 tracking-wide hover:bg-gray-900 transition-colors"
                        >
                            SIGN IN
                        </button>
                    </Form>
                </motion.div>
            </div>
        </div>
    );
}