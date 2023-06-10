import dotenv from "dotenv";
import "./globals.scss";
import { roboto } from "@/utils/fonts";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

dotenv.config();

export const metadata = {
  title: "ACE System",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className={roboto.className}>
        {children}{" "}
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
      </body>
    </html>
  );
}
