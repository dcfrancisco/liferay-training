import React, { useState, useRef } from "react";

function initializePegs(numDisks) {
  // Pegs: [peg1, peg2, peg3], each is an array (bottom to top)
  return [Array.from({ length: numDisks }, (_, i) => numDisks - i), [], []];
}

function getLegalMove(pegs, from, to) {
  if (pegs[from].length === 0) return false;
  if (pegs[to].length === 0) return true;
  return pegs[from][pegs[from].length - 1] < pegs[to][pegs[to].length - 1];
}

function TowerOfHanoi() {
  const [numDisks, setNumDisks] = useState(3);
  const [pegs, setPegs] = useState(() => initializePegs(3));
  const [moveCount, setMoveCount] = useState(0);
  const [solving, setSolving] = useState(false);
  const animationRef = useRef(null);

  const handleNumDisksChange = (e) => {
    let n = parseInt(e.target.value, 10);
    if (isNaN(n) || n < 1) n = 1;
    if (n > 13) n = 13;
    setNumDisks(n);
    setPegs(initializePegs(n));
    <div
      style={{
        height: 200,
        border: "1px solid #ccc",
        marginBottom: 10,
        position: "relative",
        background: "#f9f9f9",
        transition: "background 0.2s",
        display: "flex",
        flexDirection: "column-reverse",
        alignItems: "center",
        justifyContent: "flex-start",
        overflow: "hidden",
      }}
    >
      {/* Peg bar behind disks */}
      <div
        style={{
          position: "absolute",
          bottom: 0,
          left: "50%",
          width: 6,
          height: "100%",
          background: "#888",
          transform: "translateX(-50%)",
          zIndex: 0,
        }}
      />
      {/* Disks in front */}
      {peg.map((disk, j) => (
        <div
          key={j}
          style={{
            width: 20 + disk * 20,
            height: 20,
            background: "#1976d2",
            margin: "2px auto",
            borderRadius: 4,
            color: "white",
            fontWeight: "bold",
            textAlign: "center",
            lineHeight: "20px",
            transition: "all 0.3s",
            zIndex: 1,
            position: "relative",
          }}
        >
          {disk}
        </div>
      ))}
    </div>;
    // Animate moves
    let currentPegs = [Array.from({ length: N }, (_, i) => N - i), [], []];
    setPegs(currentPegs.map((peg) => [...peg]));
    setMoveCount(0);
    let idx = 0;
    function animate() {
      if (idx >= moveList.length) {
        setSolving(false);
        return;
      }
      const { disk, from, to } = moveList[idx];
      currentPegs[from].pop();
      currentPegs[to].push(disk);
      setPegs(currentPegs.map((peg) => [...peg]));
      setMoveCount(idx + 1);
      idx++;
      animationRef.current = setTimeout(animate, 350);
    }
    animate();
  };

  return (
    <div style={{ maxWidth: 600, margin: "0 auto", fontFamily: "sans-serif" }}>
      <h2>Tower of Hanoi</h2>
      <label>
        Number of Disks (1-13):
        <input
          type="number"
          min="1"
          max="13"
          value={numDisks}
          onChange={handleNumDisksChange}
          disabled={solving}
        />
      </label>
      <button
        onClick={solveHanoi}
        disabled={solving}
        style={{ marginLeft: 10 }}
      >
        Solve
      </button>
      <div
        style={{
          display: "flex",
          justifyContent: "space-around",
          marginTop: 30,
        }}
      >
        {pegs.map((peg, i) => (
          <div key={i} style={{ minWidth: 80, textAlign: "center" }}>
            <div
              style={{
                height: 200,
                border: "1px solid #ccc",
                marginBottom: 10,
                position: "relative",
                background: "#f9f9f9",
                transition: "background 0.2s",
                display: "flex",
                flexDirection: "column-reverse",
                alignItems: "center",
                justifyContent: "flex-start",
                overflow: "hidden",
              }}
            >
              {peg.map((disk, j) => (
                <div
                  key={j}
                  style={{
                    width: 20 + disk * 20,
                    height: 20,
                    background: "#1976d2",
                    margin: "2px auto",
                    borderRadius: 4,
                    color: "white",
                    fontWeight: "bold",
                    textAlign: "center",
                    lineHeight: "20px",
                    transition: "all 0.3s",
                  }}
                >
                  {disk}
                </div>
              ))}
              <div
                style={{
                  position: "absolute",
                  bottom: 0,
                  left: "50%",
                  width: 6,
                  height: "100%",
                  background: "#888",
                  transform: "translateX(-50%)",
                }}
              />
            </div>
            <div>Peg {i + 1}</div>
          </div>
        ))}
      </div>
      <div style={{ marginTop: 30, textAlign: "center", fontWeight: "bold" }}>
        {solving
          ? `Solving... Moves: ${moveCount}`
          : moveCount > 0
          ? `Solved in ${moveCount} moves!`
          : ""}
      </div>
    </div>
  );
}

export default TowerOfHanoi;
