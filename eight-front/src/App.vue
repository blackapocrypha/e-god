<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import LeftIndexTag from '@/components/LeftIndexTag.vue'
</script>

<template>
  <div class="app-layout">
    <aside class="app-sidebar">
      <div class="sidebar-brand">
        <img alt="logo" class="logo" src="@/assets/logo.jpg" width="56" height="56" />
      </div>
      <LeftIndexTag msg="八字排盘" />
      <nav class="sidebar-nav">
        <RouterLink to="/" class="nav-link">主页</RouterLink>
        <RouterLink to="/yearEight" class="nav-link">排盘</RouterLink>
        <RouterLink to="/timeEight" class="nav-link">流年</RouterLink>
      </nav>
    </aside>

    <main class="app-main">
      <RouterView />
    </main>
  </div>
</template>

<style scoped>
.app-layout {
  display: flex;
  gap: 60px;
  align-items: flex-start;
}

.app-sidebar {
  position: sticky;
  top: var(--space-lg);
  width: 280px;
  flex-shrink: 0;
  display: flex;
  flex-direction: column;
  gap: var(--space-md);
}

.sidebar-brand {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: var(--space-md) 0;
}

.logo {
  display: block;
  border-radius: var(--radius-md);
  box-shadow: var(--shadow-sm);
  transition: transform var(--duration-normal) var(--ease-out-quart);
}

.logo:hover {
  transform: scale(1.05);
}

/* 侧边栏底部导航 */
.sidebar-nav {
  display: flex;
  justify-content: center;
  gap: var(--space-xs);
  background: var(--color-bg-soft);
  border-radius: var(--radius-full);
  padding: 4px;
  box-shadow: var(--shadow-sm);
  margin-top: var(--space-sm);
}

.nav-link {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  padding: 8px 18px;
  font-size: var(--text-sm);
  font-weight: var(--weight-medium);
  color: var(--color-text-soft);
  border-radius: var(--radius-full);
  transition: all var(--duration-fast) var(--ease-out-quart);
}

.nav-link:hover {
  color: var(--color-text);
  background: var(--color-bg);
}

.nav-link.router-link-exact-active {
  color: #fff;
  background: var(--color-primary);
  box-shadow: 0 2px 8px oklch(52% 0.18 25 / 0.25);
}

.app-main {
  flex: 1;
  min-width: 0;
  max-width: 900px;
  display: flex;
  flex-direction: column;
  gap: var(--space-lg);
}

/* 移动端：垂直堆叠，导航移回顶部 */
@media (max-width: 1023px) {
  .app-layout {
    flex-direction: column;
    align-items: stretch;
    gap: var(--space-lg);
  }

  .app-sidebar {
    position: static;
    width: 100%;
    align-items: center;
  }

  .sidebar-nav {
    /* 移动端导航水平居中 */
    width: auto;
    margin-top: var(--space-md);
  }

  .app-main {
    max-width: none;
  }
}
</style>
