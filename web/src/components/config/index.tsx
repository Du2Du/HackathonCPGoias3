"use client"

import styles from "@/components/config/Config.module.scss";
import {useState} from "react";


export const Config: React.FC<{setActiveTab: (value: string) => void, activeTab: string}> = ({setActiveTab, activeTab}) => {

    return (
        <div>
            <div className={styles.configPanel}>
                <button className={styles.configButton+" "+(activeTab == 'alunos' ? styles.active : '' )} onClick={() => setActiveTab('alunos')}>Vincular alunos</button>
                <button className={styles.configButton+" "+(activeTab == 'params' ? styles.active : '' )} onClick={() => setActiveTab('params')}>Parametros do sistema</button>
            </div>
        </div>
    );
};
