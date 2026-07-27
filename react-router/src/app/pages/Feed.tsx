import { CreatePost } from '../components/CreatePost';
import { PostCard } from '../components/PostCard';
import { mockPosts } from '../data/mockData';

export function Feed() {
  return (
    <div className="min-h-screen bg-gray-50">
      <div className="max-w-7xl mx-auto px-6 py-8">
        <div className="grid grid-cols-12 gap-6">
          <div className="col-span-12 lg:col-span-3">
          </div>

          <div className="col-span-12 lg:col-span-6">
            <CreatePost />
            
            <div className="space-y-6">
              {mockPosts.map((post) => (
                <PostCard key={post.id} post={post} />
              ))}
            </div>
          </div>

        </div>
      </div>
    </div>
  );
}
