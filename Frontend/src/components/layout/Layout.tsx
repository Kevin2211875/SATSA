import React, { useState } from "react";
import Sidebar from "./Sidebar";
import type { PageType, LayoutProps} from "../../types";

const Layout: React.FC<LayoutProps> = ({ currentPage, setCurrentPage, children }) => {
  const [expanded, setExpanded] = useState(false);

    return (
  <div className="relative h-screen w-screen bg-app box-border overflow-hidden flex p-2">
        {/* Sidebar fijo */}
        <Sidebar
          currentPage={currentPage}
          setCurrentPage={setCurrentPage}
          expanded={expanded}
          setExpanded={setExpanded}
          className="h-full w-20 min-w-20"
        />
        {/* Main ocupa el resto */}
        <div className="flex-1 h-full ml-20 flex">
          <main className="flex-1 h-full bg-transparent rounded-2xl shadow-lg p-8 overflow-y-hidden">
            {children}
          </main>
        </div>
      </div>
    );
};
export default Layout;
