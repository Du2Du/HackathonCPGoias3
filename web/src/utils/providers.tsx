"use client";

import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { QueryClient, QueryClientProvider } from "react-query";

const query = new QueryClient({
  defaultOptions: {
    queries: {
      retry: false,
      refetchInterval: false,
    },
  },
});

export function Providers({ children }: { children: any }) {
  return (
    <QueryClientProvider client={query}>
      {children}
      <ToastContainer
        position="top-right"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="colored"
      />
    </QueryClientProvider>
  );
}
