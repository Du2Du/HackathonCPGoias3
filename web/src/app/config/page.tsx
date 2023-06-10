'use client';

import {NavBar} from "@/components/navbar";
import {Config} from "@/components/config";
import {useState} from "react";

export default function Configuration() {
    const [activeTab, setActiveTab] = useState('');

    return (
        <main>
            <NavBar />
            <div>
            <Config activeTab={activeTab} setActiveTab={setActiveTab}/>
            <div>RESAAS</div></div>
        </main>
    )
}
