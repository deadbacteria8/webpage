import { motion } from 'motion/react';
import { useParams } from 'react-router';
import { MapPin, Link as LinkIcon, Calendar, Edit } from 'lucide-react';
import { currentUser, mockUsers, mockPosts } from '../data/mockData';
import { ImageWithFallback } from '../components/figma/ImageWithFallback';


export function Profile() {
  const { id } = useParams();
  const user = id === 'me' ? currentUser : mockUsers.find(u => u.id === id) || currentUser;
  const isOwnProfile = id === 'me';

  return (
    <div className="min-h-screen bg-gray-50">
      <div className="max-w-5xl mx-auto px-6 py-8">
        {/* Profile Header */}
        <motion.div
          className="bg-white mb-6"
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
        >
          <div className="h-32 bg-black" />
          <div className="px-8 pb-8">
            <div className="flex justify-between items-start">
              <ImageWithFallback
                src={user.avatar}
                alt={user.name}
                className="w-32 h-32 object-cover border-4 border-white -mt-16"
              />
              {isOwnProfile && (
                <button className="mt-4 flex items-center gap-2 border border-black px-6 py-2 hover:bg-black hover:text-white transition-colors">
                  <Edit className="w-4 h-4" />
                  <span className="tracking-wide">EDIT</span>
                </button>
              )}
            </div>

            <div className="mt-4">
              <h1 className="text-3xl font-bold tracking-tight">{user.name}</h1>
              <p className="text-lg text-gray-600 mt-1">{user.title}</p>
              {user.bio && (
                <p className="text-gray-700 mt-4 leading-relaxed">{user.bio}</p>
              )}

              <div className="flex flex-wrap gap-6 mt-6 text-sm text-gray-600">
                <div className="flex items-center gap-2">
                  <MapPin className="w-4 h-4" />
                  <span>San Francisco, CA</span>
                </div>
                <div className="flex items-center gap-2">
                  <LinkIcon className="w-4 h-4" />
                  <a href="#" className="hover:underline">portfolio.com</a>
                </div>
                <div className="flex items-center gap-2">
                  <Calendar className="w-4 h-4" />
                  <span>Joined March 2024</span>
                </div>
              </div>

              <div className="flex gap-6 mt-6 pt-6 border-t border-gray-200">
                <div>
                  <div className="font-bold text-xl">{user.connections}</div>
                  <div className="text-sm text-gray-600 tracking-wider">CONNECTIONS</div>
                </div>
                <div>
                  <div className="font-bold text-xl">342</div>
                  <div className="text-sm text-gray-600 tracking-wider">FOLLOWERS</div>
                </div>
              </div>
            </div>
          </div>
        </motion.div>

        {/* About */}
        <motion.div
          className="bg-white p-8 mb-6"
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.1 }}
        >
          <h2 className="text-xl font-bold tracking-wide mb-4">ABOUT</h2>
          <p className="text-gray-700 leading-relaxed">
            Passionate about creating digital experiences that blend technology with artistic vision. 
            Specializing in design systems, creative coding, and innovative web applications. 
            Always exploring the cutting edge of what's possible in digital design.
          </p>
        </motion.div>

        {/* Experience */}
        <motion.div
          className="bg-white p-8 mb-6"
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ delay: 0.2 }}
        >
          <h2 className="text-xl font-bold tracking-wide mb-6">EXPERIENCE</h2>
          <div className="space-y-6">
            <div className="flex gap-4">
              <div className="w-12 h-12 bg-black flex items-center justify-center text-white font-bold">
                TC
              </div>
              <div className="flex-1">
                <h3 className="font-bold">Creative Technologist</h3>
                <p className="text-gray-600">TechCorp · Full-time</p>
                <p className="text-sm text-gray-500 mt-1">Jan 2023 - Present · 1 yr 3 mos</p>
                <p className="text-gray-700 mt-2">
                  Leading design system development and creating innovative digital experiences.
                </p>
              </div>
            </div>
          </div>
        </motion.div>

      </div>
    </div>
  );
}
