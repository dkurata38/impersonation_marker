# impersonation_maker_py

## getting start
### build image
```
docker-compose build --no-cache
```

### container starting 
```
docker-compose up -d
```

### command
```
# 特徴量の抽出
docker exec -it pyapp python mfcc.py
# 抽出した特徴量から予測
docker exec -it pyapp python predict.py
```
