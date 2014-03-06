# RLO设计

## 1. RLO是什么
RLO是RegLExicon Online，正则字典在线版。它提供了使用正则表达式查找单词的方法。

## 2. RLO的组成部分
- 字典引擎 org.beh.reglexicon
- 字典爬虫框架 org.beh.reglexicon.crawler
- 具体字典爬虫 org.beh.reglexicon.crawler.zdt

## 3. 字典引擎的结构
- Word 单词
- Dictionary 字典
- DictionaryLoader 字典加载器
- AbstractSearcher 抽象查找器
- RegexSearcher 正则查找器
- WildcardSearcher 通配查找器
- PlainSearcher 绝对查找器
- ClassicSearcher 经典查找器

## 4. 


