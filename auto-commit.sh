#!/bin/bash
cd Desktop/uni-2025/ || exit
git diff-index --quiet HEAD -- || git commit -am "Commit automático" && git push origin main
