import { Link, useLocation } from 'react-router';
import { Home,  Search,  } from 'lucide-react';
import { useAuth} from "../hooks/useAuth";

export function Header() {
  const location = useLocation();
  const { isAuthenticated } = useAuth();
  const navItems = [
    { icon: Home, label: 'FEED', path: '/' },
  ];

  const isActive = (path: string) => {
    if (path === '/') return location.pathname === '/';
    return location.pathname.startsWith(path);
  };

  return (
    <header className="fixed top-0 left-0 right-0 z-50 bg-black text-white border-b border-white/10">
      <div className="max-w-7xl mx-auto px-6">
        <div className="flex items-center justify-between h-16">
          {/* Logo */}
          <Link to="/" className="text-2xl font-bold tracking-tighter">
            SYNC
          </Link>

          {/* Search */}
          <div className="hidden md:flex items-center flex-1 max-w-md mx-8">
            <div className="relative w-full">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-gray-400" />
              <input
                type="text"
                placeholder="SEARCH"
                className="w-full bg-white/5 border border-white/10 pl-10 pr-4 py-2 text-sm tracking-wider focus:outline-none focus:border-white/30 transition-colors"
              />
            </div>
          </div>
          <nav className="flex items-center gap-1">
            {navItems.map((item) => (
              <Link
                key={item.path}
                to={item.path}
                className={`flex flex-col items-center gap-1 px-4 py-2 transition-colors ${
                  isActive(item.path)
                    ? 'text-white'
                    : 'text-gray-500 hover:text-white'
                }`}
              >
                <item.icon className="w-5 h-5" />
                <span className="text-[10px] tracking-widest hidden md:block">
                  {item.label}
                </span>
              </Link>
            ))}


            {isAuthenticated && (
                <Link
                    to="/profile/me"
                    className="ml-4 w-8 h-8 rounded-full bg-white/10 border border-white/20 flex items-center justify-center hover:border-white/40 transition-colors"
                >
                  <span className="text-sm font-bold">ME</span>
                </Link>
            )}
            {!isAuthenticated && (
                <Link
                    to="/login"
                    className="px-4 py-2 text-sm rounded-lg bg-white text-black hover:bg-white/90 transition"
                >
                  Login
                </Link>
            )}
          </nav>
        </div>
      </div>
    </header>
  );
}
