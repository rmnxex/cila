import React, { useState } from 'react';

export default function LoveStory() {
  const [slide, setSlide] = useState(1);
  const [noClicks, setNoClicks] = useState(0);
  const [noPosition, setNoPosition] = useState({ top: 50, left: 80 });

  const handleNext = () => setSlide(slide + 1);

  const handleNo = () => {
    setNoClicks(noClicks + 1);
    setNoPosition(getRandomPosition());
  };

  // Generate random but safe button positions away from the center
  const getRandomPosition = () => {
    let top, left;
    do {
      top = 10 + Math.random() * 70; // between 10% and 80%
      left = Math.random() < 0.5 ? 10 + Math.random() * 25 : 65 + Math.random() * 25; // avoid center 40%-60%
    } while (left > 40 && left < 60);
    return { top, left };
  };

  return (
    <div className="h-screen w-full flex flex-col items-center justify-center bg-gradient-to-b from-black via-zinc-900 to-neutral-900 text-gray-100 text-center p-6 overflow-hidden relative">
      {slide === 1 && (
        <div>
          <h1 className="text-5xl font-serif mb-6">Welcome</h1>
          <button onClick={handleNext} className="px-6 py-3 bg-white/10 rounded-full border border-white/20 hover:bg-white/20 transition">Next</button>
        </div>
      )}

      {slide === 2 && (
        <div>
          <p className="text-lg md:text-xl opacity-90 max-w-xl mx-auto mb-8">
            Hi Cila, I just want to say that every moment with you means a lot to me. <br />
            This page is a small piece of my heart, a way to say I still care, and I still believe in what we had. I just want you to know that I will always care for you even if there’s no one left on this planet. I just want you to think clearly before coming to a conclusion. I just want you to be happy — that’s all that matters to me. The way touch me. The way you talk to me. Every little words that has come from your mouth it's a song for me. Just try again with me please i'm begging you on my life. Aku bakal ngertiin kamu lebih lagi. Aku bakal lebih straight forward lagi.
          </p>
          <button onClick={handleNext} className="px-6 py-3 bg-white/10 rounded-full border border-white/20 hover:bg-white/20 transition">Next</button>
        </div>
      )}

      {slide === 3 && (
        <div className="flex flex-col items-center">
          <div className="w-72 h-72 rounded-2xl overflow-hidden border border-zinc-700 mb-6">
            <img src="/us-photo.jpg" alt="Us" className="w-full h-full object-cover" />
          </div>
          <button onClick={handleNext} className="px-6 py-3 bg-white/10 rounded-full border border-white/20 hover:bg-white/20 transition">Next</button>
        </div>
      )}

      {slide === 4 && (
        <div className="flex flex-col items-center justify-center gap-6 w-full h-full relative">
          <h2 className="text-3xl md:text-4xl font-serif mb-6">Do you want to try again with me?</h2>

          <div className="relative w-full flex flex-col items-center justify-center gap-6">
            {noClicks < 3 && (
              <button
                onClick={handleNo}
                className="bg-red-600/80 rounded-full text-white border border-red-400/50 transition-all px-6 py-3 absolute"
                style={{
                  top: `${noPosition.top}%`,
                  left: `${noPosition.left}%`,
                  transform: 'translate(-50%, -50%)',
                  zIndex: 10
                }}
              >
                No
              </button>
            )}

            <button
              onClick={() => alert('Thank you ❤️')}
              className="bg-green-600/80 rounded-full text-white border border-green-400/50 transition-all z-20"
              style={{
                padding: `${12 + noClicks * 12}px ${24 + noClicks * 24}px`,
                fontSize: `${16 + noClicks * 4}px`,
                position: noClicks >= 3 ? 'absolute' : 'relative',
                top: noClicks >= 3 ? 0 : 'auto',
                left: noClicks >= 3 ? 0 : 'auto',
                width: noClicks >= 3 ? '100%' : 'auto',
                height: noClicks >= 3 ? '100%' : 'auto'
              }}
            >
              Yes
            </button>
          </div>
        </div>
      )}
    </div>
  );
}
